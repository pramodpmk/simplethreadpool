# simplethreadpool
Library to perform tasks in multiple threads
Can make use of multiple cores in processor of device. Executes a task on multiple threads when needed.

In your build.gradle:

 dependencies {
   compile 'org.pramodwacmob:SimpleThreadpool:1.0.0'
 }
 
 To execute background tasks.
 
 DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do some background work here.
                      
                    }
                });
                
  To execute UI tasks.
  
  DefaultExecutorSupplier.getInstance().forMainThreadTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do someUI work here.
                       
                    }
                });
