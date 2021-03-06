package com.bing.excel.vo;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * listrow 对象
 *
 * @author shizhongtao
 * date 2016-2-17 Description:
 */
public class ListLine {
  private List<CellKV<String>> listStr = null;
  private List<CellKV<Double>> listDouble = null;
  private List<CellKV<Boolean>> listBoolean = null;
  private List<CellKV<Date>> listDate = null;
  private List<CellKV<Long>> listLong = null;
  private int minIndex = -1;
  private int maxIndex = -1;

  @SuppressWarnings("unchecked")
  public List<CellKV<String>> getListStr() {

    return listStr == null ? Collections.EMPTY_LIST : ImmutableList.copyOf(listStr);
  }

  @SuppressWarnings("unchecked")
  public List<CellKV<Double>> getListDouble() {
    return listDouble == null ? Collections.EMPTY_LIST : ImmutableList.copyOf(listDouble);
  }

  @SuppressWarnings("unchecked")
  public List<CellKV<Boolean>> getListBoolean() {
    return listBoolean == null ? Collections.EMPTY_LIST : ImmutableList.copyOf(listBoolean);
  }

  @SuppressWarnings("unchecked")
  public List<CellKV<Date>> getListDate() {
    return listDate == null ? Collections.EMPTY_LIST : ImmutableList.copyOf(listDate);
  }

  @SuppressWarnings("unchecked")
  public List<CellKV<Long>> getListLong() {
    return listLong == null ? Collections.EMPTY_LIST : ImmutableList.copyOf(listLong);
  }
  public Object[] toFullArray() {
    int maxIndex = this.getMaxIndex();
    Object[] objArr = new Object[maxIndex+1];
    if (maxIndex != -1) {
      for (CellKV<String> kv : this.getListStr()) {
        objArr[kv.getIndex()] = kv.getValue();
      }
      for (CellKV<Boolean> kv : this.getListBoolean()) {
        objArr[kv.getIndex()] = kv.getValue();
      }
      for (CellKV<Date> kv : this.getListDate()) {
        objArr[kv.getIndex()] = kv.getValue();
      }
      for (CellKV<Double> kv : this.getListDouble()) {
        objArr[kv.getIndex()] = kv.getValue();
      }
      for (CellKV<Long> kv : this.getListLong()) {
        objArr[kv.getIndex()] = kv.getValue();
      }
    }
    return objArr;
  }
  public ListLine addValue(int index, int value) {
    return addValue(index, (long) value);

  }

  public ListLine addValue(int index, long value) {
    if (listLong == null) {
      listLong = new ArrayList<>();
    }
    listLong.add(new CellKV<Long>(index, value));
    changeIndex(index);
    return this;
  }

  public ListLine addValue(int index, double value) {
    if (listDouble == null) {
      listDouble = new ArrayList<>();
    }
    changeIndex(index);
    listDouble.add(new CellKV<Double>(index, value));
    return this;
  }



  public ListLine addValue(int index, String value) {
    if (listStr == null) {
      listStr = new ArrayList<>();
    }
    listStr.add(new CellKV<String>(index, value));
    changeIndex(index);
    return this;
  }

  public ListLine addValue(int index, boolean value) {
    if (listBoolean == null) {
      listBoolean = new ArrayList<>();
    }
    listBoolean.add(new CellKV<Boolean>(index, value));
    changeIndex(index);
    return this;
  }

  public ListLine addValue(int index, Date value) {
    if (listDate == null) {
      listDate = new ArrayList<>();
    }
    listDate.add(new CellKV<Date>(index, value));
    changeIndex(index);
    return this;
  }


  private void changeIndex(int index) {
    if (index > maxIndex) {
      maxIndex = index;
    }
    if (minIndex == -1) {
      minIndex = index;
    } else {
      if (index < minIndex) {
        minIndex = index;
      }
    }
  }

  public int getMinIndex() {
    return minIndex;
  }

  public int getMaxIndex() {
    return maxIndex;
  }
}
