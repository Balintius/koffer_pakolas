package hu.lokter.mi.algorithm;

import hu.lokter.mi.model.Koffer;

/**
 * Created by Balint on 2017. 10. 08..
 */
public abstract class KofferAlgorithm {
    Koffer koffer;
    KofferAlgorithm(Koffer koffer){this.koffer = koffer;}
    public int order(){return 0;}
    public final void print()
    {
        System.out.print(koffer);
    }
}
