public class StrategyContext {
    private UndoStrategy strategy;

    public void setStrategy(UndoStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.execute();
        } else {
            System.out.println("No strategy set!");
        }
    }
}
