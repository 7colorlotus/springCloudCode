About queue：

1 queue-name

The queue name MAY be empty, in which case the server MUST create a new queue with a unique generated name and return this to the client in the Declare-Ok method.

2 passive

If set, the server will reply with Declare-Ok if the queue already exists with the same name, and raise an error if not.

3 durable

If set when creating a new queue, the queue will be marked as durable. Durable queues remain active when a server restarts. Non-durable queues (transient queues) are purged if/when a server restarts. Note that durable queues do not necessarily hold persistent messages, although it does not make sense to send persistent messages to a transient queue.

The server MUST recreate the durable queue after a restart.

The server MUST support both durable and transient queues.

4 exclusive

Exclusive queues may only be accessed by the current connection, and are deleted when that connection closes. Passive declaration of an exclusive queue by other connections are not allowed.

The server MUST support both exclusive (private) and non-exclusive (shared) queues.

The client MAY NOT attempt to use a queue that was declared as exclusive by another still-open connection. Error code: resource-locked

5 auto-delete

If set, the queue is deleted when all consumers have finished using it. The last consumer can be cancelled either explicitly or because its channel is closed. If there was no consumer ever on the queue, it won't be deleted. Applications can explicitly delete auto-delete queues using the Delete method as normal.

The server MUST ignore the auto-delete field if the queue already exists.

About exchange：

1 passive

If set, the server will reply with Declare-Ok if the exchange already exists with the same name, and raise an error if not.

2 durable

If set when creating a new exchange, the exchange will be marked as durable. Durable exchanges remain active when a server restarts. Non-durable exchanges (transient exchanges) are purged if/when a server restarts.

3 auto-delete

If set, the exchange is deleted when all queues have finished using it.

The server SHOULD allow for a reasonable delay between the point when it determines that an exchange is not being used (or no longer used), and the point when it deletes the exchange. At the least it must allow a client to create an exchange and then bind a queue to it, with a small but non-zero delay between these two actions.

The server MUST ignore the auto-delete field if the exchange already exists.

4 internal

If set, the exchange may not be used directly by publishers, but only when bound to other exchanges. Internal exchanges are used to construct wiring that is not visible to applications.