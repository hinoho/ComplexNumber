//package ru.skillbench.tasks.basics.math;

import java.util.Arrays;
import java.util.Objects;

public class ComplexNumberImpl implements ComplexNumber {
    private double re = 0, im = 0;

    public ComplexNumberImpl() {
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im==0;
    }

    @Override
    public void set(double re, double im) {
        this.im = im;
        this.re = re;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        String[] tmp = value.replaceAll("-|\\+"," ").trim().split(" ");

        if(tmp.length==2){
            re = Double.parseDouble(tmp[0]);
            if(value.substring(0,1).equals("-")){
                re*=-1;
            }
            if(tmp[1].equals("i")) im=1;
            else{
                im = Double.parseDouble(tmp[1].replace("i",""));
            }
            if(value.lastIndexOf("-")>0){
                im*=-1;
            }
        }
        else if(tmp.length==1){
            if(value.contains("i")){
                re = 0;
                if(tmp[0].equals("i")) im=1;
                else{
                    im = Double.parseDouble(tmp[0].replace("i",""));
                }
                if(value.contains("-")){
                    im*=-1;
                }
            }
            else {
                im  =0;
                re = Double.parseDouble(tmp[0]);
                if(value.substring(0,1).equals("-")){
                    re*=-1;
                }
            }
        }
        else {
            re=0;
            im=0;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(re!=0.0) stringBuilder.append(re);
        if(re!=0.0&&im>0.0)stringBuilder.append("+");
        if(im!=0.0) stringBuilder.append(im).append("i");
        return stringBuilder.toString();
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber copy = new ComplexNumberImpl();
        copy.set(this.re, this.im);
        return copy;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        ComplexNumber clone = new ComplexNumberImpl(re,im);
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ComplexNumber)) return false;
        ComplexNumberImpl that = (ComplexNumberImpl) o;
        return Double.compare(that.getRe(), getRe()) == 0 &&
                Double.compare(that.getIm(), getIm()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRe(), getIm());
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double num1 = Math.pow(re,2)  +Math.pow(im,2);
        double num2 = Math.pow(other.getRe(),2)  +Math.pow(other.getIm(),2);
        if(num1>num2)return 1;
        if(num1==num2)return 0;
        return -1;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.set(-re,-im);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.set(this.re+arg2.getRe(), this.im + arg2.getIm());
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        this.set(this.re * arg2.getRe() - this.im * arg2.getIm(), this.im* arg2.getRe() + this.re * arg2.getIm());
        return this;
    }
}