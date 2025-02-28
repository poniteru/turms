/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.server.common.healthcheck;

import com.sun.management.OperatingSystemMXBean;
import im.turms.server.common.logging.core.logger.Logger;
import im.turms.server.common.logging.core.logger.LoggerFactory;
import im.turms.server.common.property.env.common.healthcheck.CpuHealthCheckProperties;

import java.lang.management.ManagementFactory;

/**
 * @author James Chen
 */
public final class CpuHealthChecker extends HealthChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(CpuHealthChecker.class);

    private final OperatingSystemMXBean operatingSystemBean;

    private final boolean isCpuHealthCheckAvailable;
    private final int cpuCheckRetries;
    private final float unhealthyLoadThreshold;

    private boolean isCpuHealthy;
    private int currentUnhealthyTimes;

    public CpuHealthChecker(CpuHealthCheckProperties properties) {
        operatingSystemBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        cpuCheckRetries = properties.getRetries();
        unhealthyLoadThreshold = properties.getUnhealthyLoadThresholdPercentage() / 100F;
        double cpuLoad = operatingSystemBean.getCpuLoad();

        boolean isCpuHealthCheckAvailable = true;
        if (cpuLoad < 0) {
            LOGGER.warn("CPU health checker cannot work because the \"recent cpu usage\" for the whole operating environment is unavailable");
            isCpuHealthCheckAvailable = false;
            isCpuHealthy = true;
        }
        this.isCpuHealthCheckAvailable = isCpuHealthCheckAvailable;
        updateHealthStatus();
    }

    @Override
    public boolean isHealthy() {
        return isCpuHealthy;
    }

    @Override
    public void updateHealthStatus() {
        if (!isCpuHealthCheckAvailable) {
            return;
        }
        boolean wasCpuHealthy = isCpuHealthy;
        double cpuLoad = operatingSystemBean.getCpuLoad();
        if (cpuLoad > unhealthyLoadThreshold) {
            currentUnhealthyTimes++;
            if (currentUnhealthyTimes > cpuCheckRetries) {
                isCpuHealthy = false;
            }
        } else {
            currentUnhealthyTimes = 0;
            isCpuHealthy = true;
        }

        // Log
        LOGGER.debug("CPU load: {}", cpuLoad);
        if (wasCpuHealthy != isCpuHealthy) {
            if (isCpuHealthy) {
                LOGGER.info("The CPU has become healthy. The current CPU load: {}", cpuLoad);
            } else {
                LOGGER.info("The CPU has become unhealthy. The current CPU load: {}", cpuLoad);
            }
        }
    }

}
