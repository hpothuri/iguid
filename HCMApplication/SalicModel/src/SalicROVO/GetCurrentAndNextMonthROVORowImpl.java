package SalicROVO;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Nov 10 00:38:50 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class GetCurrentAndNextMonthROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Cmonth {
            protected Object get(GetCurrentAndNextMonthROVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            protected void put(GetCurrentAndNextMonthROVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected abstract Object get(GetCurrentAndNextMonthROVORowImpl object);

        protected abstract void put(GetCurrentAndNextMonthROVORowImpl object, Object value);

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int CMONTH = AttributesEnum.Cmonth.index();

    /**
     * This is the default constructor (do not remove).
     */
    public GetCurrentAndNextMonthROVORowImpl() {
    }
}

