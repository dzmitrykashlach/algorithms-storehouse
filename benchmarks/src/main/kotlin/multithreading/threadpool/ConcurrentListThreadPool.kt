package multithreading.threadpool

import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.LinkedBlockingQueue

class ConcurrentListThreadPool {

    val workingQueue = LinkedBlockingQueue<PoolRunnable>()
    val workers = ConcurrentSkipListSet<PoolRunnable>()
    private var isStopped = false

    /* FIXME

    init {
        for (w in workers) {
            val poolThreadRunnable: PoolRunnable =
                PoolRunnable(workingQueue)

            w = poolThreadRunnable
        }
        for (w in workers) {
            Thread(w).start()
        }
    }
*/

    fun execute(task: PoolRunnable) {
        if (this.isStopped) throw IllegalStateException("ThreadPool is stopped");

        this.workingQueue.offer(task);
    }

    fun stop() {
        this.isStopped = true
        for (w in workers) {
            w.doStop()
        }
    }
}