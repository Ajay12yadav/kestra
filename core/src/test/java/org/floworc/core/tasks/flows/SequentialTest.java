package org.floworc.core.tasks.flows;

import org.floworc.core.AbstractMemoryRunnerTest;
import org.floworc.core.models.executions.Execution;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class SequentialTest extends AbstractMemoryRunnerTest {
    @Test
    void sequential() throws TimeoutException {
        Execution execution = runnerUtils.runOne("org.floworc.tests", "sequential");

        assertThat(execution.getTaskRunList(), hasSize(11));
    }

    @Test
    void sequentialWithGlobalErrors() throws TimeoutException {
        Execution execution = runnerUtils.runOne("org.floworc.tests", "sequential-with-global-errors");

        assertThat(execution.getTaskRunList(), hasSize(6));
    }

    @Test
    void sequentialWithLocalErrors() throws TimeoutException {
        Execution execution = runnerUtils.runOne("org.floworc.tests", "sequential-with-local-errors");

        assertThat(execution.getTaskRunList(), hasSize(6));
    }
}