package SalicROVO;

import java.math.BigDecimal;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 21 17:10:25 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CountryROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public CountryROVOImpl() {
    }

    /**
     * Returns the bind variable value for bindRegionId.
     * @return bind variable value for bindRegionId
     */
    public BigDecimal getbindRegionId() {
        return (BigDecimal) getNamedWhereClauseParam("bindRegionId");
    }

    /**
     * Sets <code>value</code> for bind variable bindRegionId.
     * @param value value to bind as bindRegionId
     */
    public void setbindRegionId(BigDecimal value) {
        setNamedWhereClauseParam("bindRegionId", value);
    }
}

