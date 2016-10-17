package business_logic;

import business_logic.exceptions.FieldRequiredException;
import data_access.GrantConditionCRUD;
import data_access.entity.GrantCondition;
import data_access.entity.LoanType;

import java.util.List;

/**
 * Created by dotinschool3 on 10/15/2016.
 */
public class GrantConditionLogic {
    private static Boolean validate(List<GrantCondition> grantConditions) {
        if (grantConditions == null) {
            throw new FieldRequiredException("وارد کردن حداقل یک شرط اعطا الزامی است.");
        }
        return true;
    }

    public static void insertGrantConditions(LoanType loanType, List<GrantCondition> grantConditions) {
        if (validate(grantConditions)) {

            GrantConditionCRUD.insertIntoTable(loanType, grantConditions);
        }
    }
}

