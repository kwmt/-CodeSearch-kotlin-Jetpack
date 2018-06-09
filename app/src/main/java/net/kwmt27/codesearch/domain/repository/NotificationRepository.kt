package net.kwmt27.codesearch.domain.repository

import com.jakewharton.rxrelay2.BehaviorRelay
import net.kwmt27.codesearch.domain.model.PushMessage

/**
 * 通知リポジトリ
 */
interface NotificationRepository {

    /**
     * Androidの通知エリアに通知する。
     * @param pushMessage pushMessage
     * @return BehaviorRelay<Boolean>インスタンス
     * true:通知した
     * false: 通知していない
     */
    fun notify(pushMessage: PushMessage): BehaviorRelay<Boolean>
}