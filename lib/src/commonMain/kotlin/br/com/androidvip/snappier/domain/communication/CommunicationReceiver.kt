package br.com.androidvip.snappier.domain.communication

fun interface CommunicationReceiver {
    /**
     * Called when a component sends data to other components.
     *
     * @param data Communication data. Some platforms impose limit on this object's size.
     * @param targetComponentIds Specific components IDs to which the [data] is intended.
     * Can be `null`, denoting no particular component.
     */
    fun receiveCommunication(data: Map<String, Any?>, targetComponentIds: List<String>?)
}
