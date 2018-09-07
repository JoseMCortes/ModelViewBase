package com.josecortes.poclivedata.repositories

import com.josecortes.poclivedata.model.Item
import java.util.*
import java.util.concurrent.TimeUnit


typealias ItemsListener = (Item) -> Unit

/**
 * Fake repository that will emit a new data change simulation every second
 */
class ItemRepository {

    private val timer = Timer()
    private val random = Random()
    private val period = TimeUnit.SECONDS.toMillis(1)


    internal fun findItems(itemsReceived: ItemsListener) {
        // Emit a fake data change update every period of time
        timer.schedule(object : TimerTask() {
            override fun run() {
                val value = random.nextInt(1000)
                itemsReceived.invoke(Item(value, "Description_$value"))
            }
        }, period, period)
    }
}