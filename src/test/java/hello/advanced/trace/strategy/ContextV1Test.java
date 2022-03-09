package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비즈니스 로직1 실행");

        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        log.info("비즈니스 로직2 실행");

        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        ContextV1 contextV1 = new ContextV1(new StrategyLogic1());
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new StrategyLogic2());
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = () -> log.info("비즈니스 로직1 실행");
        strategyLogic1.call();

        Strategy strategyLogic2 = () -> log.info("비즈니스 로직2 실행");
        strategyLogic2.call();
    }
}
