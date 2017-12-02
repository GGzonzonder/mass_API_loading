/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mass_api_loading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GGininder
 */
public class Mass_api_loading {
    static int finish_count = 0;
    static long loop_size = 100000L;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        api_manager am = new api_manager();
        boolean is_sync = false;//is object synchronized or not
        am.setapi_type(0);//change here, 0 is no balanced, 1 is balanced
        System.out.println("api synchronized: "+is_sync);

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*4);
        long st = System.currentTimeMillis();
        for (int a = 0; a < 4; a++) {
            SimpleAdd(pool, am.getapi(a), is_sync).whenComplete((ok, ex) -> {
                finish_count += ok;
                //System.out.println(finish_count);
            });
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    if (finish_count == loop_size*4) {
                        long et = System.currentTimeMillis();
                        pool.shutdown();
                        System.out.println((et-st)+"ms.");
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mass_api_loading.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
        
    }
    
    
    public static CompletableFuture<Long> SimpleAdd(ExecutorService pool, target_api ta, boolean is_sync) {
        return CompletableFuture.supplyAsync(() -> {
            return new work_todo(ta).cal(is_sync);
        }, pool);
    }
}
