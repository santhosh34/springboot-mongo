package com.aureole.tradeflow.constants;

import com.aureole.tradeflow.util.Constants;
import com.aureole.tradeflow.model.availability.Health;

public enum HealthEnum {
    HEALTHY{
        @Override
        public Health getHealthStatus(){
            return Health.builder().status(Constants.HEALTHY).build();
        }

    },
    UNHEALTHY{
        @Override
        public Health getHealthStatus(){
            return Health.builder().status(Constants.UNHEALTHY).build();
        }
    };

    public  abstract Health  getHealthStatus();


}
