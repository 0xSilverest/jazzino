package com.silverest.entities.utils;

import com.silverest.entities.Dealer;
import com.silverest.entities.Hand;

public class DealerCompanion {
    public static Dealer createDealer() {
        return new Dealer("Dealer Joe", Hand.empty());
    }
}
