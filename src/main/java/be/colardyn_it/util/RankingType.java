package be.colardyn_it.util;

/**
 * Created by stijnhaesendonck on 25/01/2017.
 */
public enum RankingType {
    CPU, CPUCORE, CPUCORECOUNT, CPUSOCKET, CPUSUBFAMILY, // HWBOT-1886 add CPUSUBFAMILY
    GPU, GPUFAMILY, GPUCORE, GPUSOCKET, GPUSOCKETCATEGORY,
    MBMODEL, MEM, MBCHIPSET, PSU, DISK, SOCKET

}
