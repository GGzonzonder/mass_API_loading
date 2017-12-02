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
public class target_api {
    
    public synchronized long sync_add(long num) {
        for (long c = 0; c < Mass_api_loading.loop_size; c++) {
            num++;
        }
        num -= Mass_api_loading.loop_size;
        num++;
        return num;
    }
    
    public long non_sync_add(long num) {
        for (long c = 0; c < Mass_api_loading.loop_size; c++) {
            num++;
        }
        num -= Mass_api_loading.loop_size;
        num++;
        return num;
    }
}
