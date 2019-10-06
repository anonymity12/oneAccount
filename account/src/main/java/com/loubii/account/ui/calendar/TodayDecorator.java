package com.loubii.account.ui.calendar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;


/*
* 装载 今天选中 的绿色 deco，这是deco1 ， 还有deco2 ： CountDecorator.java
* */
public class TodayDecorator implements DayViewDecorator {
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        if (day.getDate().equals(CalendarDay.today().getDate())) {
            return true;
        }
        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new TodaySpan());
    }
}
