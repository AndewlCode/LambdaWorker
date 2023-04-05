public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener errorListener = System.out::println;

        Worker worker = new Worker(listener, errorListener);
        
        worker.start();
    }

    public static class Worker {
        private OnTaskDoneListener callback;
        private  OnTaskErrorListener errorListener;

            public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorListener) {
            this.callback = callback;
            this.errorListener = errorListener;
        }

        public void start() {
            for (int i = 0; i < 100; i++) {
                callback.onDone("Task " + i + " is done");
                if (i==33){
                    errorListener.onError("Task " + i + " is an ERROR!");
                }
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String result);
    }
}
