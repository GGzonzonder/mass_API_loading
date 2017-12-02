/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mass_api_loading;

/**
 *
 * @author GGininder
 */
public class work_todo{
    target_api ta;
    long num = 0L;
    
    public work_todo(target_api ta) {
        this.ta = ta;
    }
        
    public long cal(boolean is_sync) {
        if (is_sync) {
            for (long c = 0; c < Mass_api_loading.loop_size; c++) {
                //num = this.ta.non_sync_add(num);
                num = this.ta.sync_add(num);
            }
            System.out.println("sync add done. num = " + num);
        } else {
            for (long c = 0; c < Mass_api_loading.loop_size; c++) {
                num = this.ta.non_sync_add(num);
            }
            System.out.println("non-sync add done. num = " + num);
        }
        
        return num;
    }
    
}
