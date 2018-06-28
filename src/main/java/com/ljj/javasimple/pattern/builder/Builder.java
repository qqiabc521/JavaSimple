package com.ljj.javasimple.pattern.builder;

public abstract class Builder {
    public abstract void setCpu(String cpu);

    public abstract void setMainboard(String mainboard);

    public abstract void setRam(String ram);

    public abstract Computer create();
}
