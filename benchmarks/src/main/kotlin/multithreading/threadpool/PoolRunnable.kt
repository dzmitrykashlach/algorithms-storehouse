package multithreading.threadpool

import java.util.concurrent.BlockingQueue


class PoolRunnable(queue: BlockingQueue<*>?) : Runnable {
    private var thread: Thread? = null
    private var taskQueue: BlockingQueue<*>? = null
    private var isStopped = false

    init {
        taskQueue = queue
    }

    override fun run() {
        this.thread = Thread.currentThread()
        while (!isStopped()) {
            try {
                val runnable = taskQueue!!.take() as Runnable
                runnable.run()
            } catch (e: Exception) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    @Synchronized
    public fun doStop() {
        isStopped = true
        //break pool thread out of dequeue() call.
        thread!!.interrupt()
    }

    @Synchronized
    fun isStopped(): Boolean {
        return isStopped
    }
}