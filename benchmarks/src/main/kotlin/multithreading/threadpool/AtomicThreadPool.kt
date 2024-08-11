package multithreading.threadpool

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.atomic.AtomicReferenceArray

class AtomicThreadPool(capacity: Int) {

    private var workingQueue: LinkedBlockingQueue<PoolRunnable> = LinkedBlockingQueue(capacity)
    private val workers = AtomicReferenceArray<PoolRunnable>(capacity)
    private var isStopped = false

    init {
        for (i in 0 until workers.length()) {
            val poolThreadRunnable: PoolRunnable =
                PoolRunnable(workingQueue)

            workers[i] = poolThreadRunnable
        }
        for (i in 0 until workers.length()) {
            Thread(workers[i]).start()
        }
    }

    fun execute(task: PoolRunnable) {
        if (this.isStopped) throw IllegalStateException("ThreadPool is stopped");

        this.workingQueue.offer(task);
    }

    fun stop() {
        this.isStopped = true
        for (i in 0 until workers.length()) {
            workers[i].doStop()
        }
    }
}