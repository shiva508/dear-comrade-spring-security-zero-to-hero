## DelegatingSecurityContextExecutor:
### Implements the Executor interface and is designed to decorate an Executor object with the capability of forwarding the security context to the threads created by its pool.
## DelegatingSecurityContextExecutorService:
### Implements the ExecutorService interface and is designed to decorate an ExecutorService object with the capability of forwarding the security context to the threads created by its pool.
## DelegatingSecurityContextScheduledExecutorService:
### Implements the ScheduledExecutorService interface and is designed to decorate a ScheduledExecutorService object with the capability of forwarding the security context to the threads created by its pool.
## DelegatingSecurityContextRunnable:
### Implements the Runnable interface and represents a task that is executed on a different thread without returning a response. Above a normal Runnable, it can also propagate a security context to use on the new thread.
## DelegatingSecurityContextCallable:
### Implements the Callable interface and represents a task that is executed on a different thread and that will eventually return a response. Above a normal Callable, it can also propagate a security context to use on the new thread.