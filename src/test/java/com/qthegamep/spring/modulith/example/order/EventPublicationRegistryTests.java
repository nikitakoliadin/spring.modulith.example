package com.qthegamep.spring.modulith.example.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.ApplicationModuleListener;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.*;

@ApplicationModuleTest
@Import(EventPublicationRegistryTests.FailingAsyncTransactionalEventListener.class)
@DirtiesContext
@RequiredArgsConstructor
public class EventPublicationRegistryTests {

    private final OrderManagement orders;
    private final EventPublicationRegistry registry;
    private final FailingAsyncTransactionalEventListener listener;

    @Test
    void leavesPublicationIncompleteForFailingListener(Scenario scenario) {
        var order = new Order();

        scenario.stimulate(() -> orders.complete(order))
                .andWaitForStateChange(listener::getException)
                .andVerify(__ -> assertThat(registry.findIncompletePublications()).hasSize(1));
    }

    @Getter
    static class FailingAsyncTransactionalEventListener {

        Exception exception;

        @ApplicationModuleListener
        void complete(OrderCompleted ignoredEvent) {
            var exception = new IllegalStateException("¯\\_(ツ)_/¯");

            try {
                throw exception;
            } finally {
                this.exception = exception;
            }
        }
    }
}
