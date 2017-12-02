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
public class api_manager {
    target_api ta1 = new target_api();
    target_api ta2 = new target_api();
    target_api ta3 = new target_api();
    target_api ta4 = new target_api();
    int type = 0;//0, not balanced  1, balanced 
    
    public void setapi_type(int type) {
        if (type == 0) {
            this.type = 0;
            System.out.println("not balanced the api loading.");
            return;
        }
        if (type == 1) {
            this.type = 1;
            System.out.println("balanced the api loading.");
            return;
        }
        System.out.println("not balanced the api loading.");
        this.type = 0;
        
    }
    
    
    public target_api getapi(int c) {
        if (this.type == 0) {
            return ta1;
        }
        if (this.type == 1) {
            switch (c) {
                case 0:
                    return ta1;
                case 1:
                    return ta2;
                case 2:
                    return ta3;
                case 3:
                    return ta4;
                default:
                    break;
            }
        }
        return ta1;
    }
}
