package com.linx.Pojo;

/**
 * @title: CpuInfo2
 * @Author yqliu
 * @Date: 2022/3/17 下午10:11
 * @Version 1.0
 */
public class CpuInfo {
    public static int CPU;
    public String Family;
    public String Model;
    //    private long Stepping;
//    private String PhysicalID;
//    private String CoreID;
//    private long Cores;
//    private String ModelName;
//    private float Mhz;
//    private long CacheSize;
//    private String Flags;
//    private String Microcode;
    public double Percent;

    public long getCPU() {
        return CPU;
    }

    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getPercent() {
        return Percent;
    }

    public void setPercent(double percent) {
        Percent = percent;
    }
}
