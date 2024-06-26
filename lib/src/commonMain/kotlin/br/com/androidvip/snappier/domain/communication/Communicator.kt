package br.com.androidvip.snappier.domain.communication

interface Communicator {
    fun communicateData(data: Map<String, Any?>, targetComponentIds: List<String>?)
    fun attachReceiver(receiver: CommunicationReceiver)
    fun detachReceiver(receiver: CommunicationReceiver)
}
