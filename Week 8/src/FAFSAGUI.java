import javax.swing.JOptionPane;

/**
 * FAFSAGUI.java
 *
 * A Graphical User Interface for the FAFSA program.
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, Lab Section G06
 *
 * @version October 15, 2016
 *
 */
public class FAFSAGUI {

    /**
     * Program's main entry point
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // TODO
        // should the program do something about empty inputs?

        boolean beginApp = true;
        boolean isAcceptedStudent;
        boolean isSSregistered;
        boolean hasSSN;
        boolean hasValidResidency;
        boolean isDependent;

        while (beginApp) {
            JOptionPane.showMessageDialog(null, "Welcome to FAFSA!", "Welcome", JOptionPane.INFORMATION_MESSAGE);

            int isAccepted = JOptionPane.showOptionDialog(null, "Have you been accepted into a degree or certificate program?", "Program Acceptance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            isAcceptedStudent = (isAccepted == JOptionPane.YES_OPTION);

            int isRegistered = JOptionPane.showOptionDialog(null, "Are you registered for the selective service?", "Selective Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            isSSregistered = (isRegistered == JOptionPane.YES_OPTION);

            int haveSS = JOptionPane.showOptionDialog(null, "Do you have a social security number?", "Social Security Number", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            hasSSN = (haveSS == JOptionPane.YES_OPTION);

            int validRes = JOptionPane.showOptionDialog(null, "Do you have valid residency status?", "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            hasValidResidency = (validRes == JOptionPane.YES_OPTION);

            String validAge = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);
            while (!(Integer.parseInt(validAge) > 0)) {
                JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: Age", JOptionPane.ERROR_MESSAGE);
                validAge = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);

            }

            String validCreditHours = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?", "Credit Hours", JOptionPane.QUESTION_MESSAGE);
            while (!((Integer.parseInt(validCreditHours) >= 1) && (Integer.parseInt(validCreditHours) <= 24))) {
                JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, inclusive.", "Error:  Credit Hours", JOptionPane.ERROR_MESSAGE);
                validCreditHours = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?", "Credit Hours", JOptionPane.QUESTION_MESSAGE);

            }

            String validStudentIncome = JOptionPane.showInputDialog(null, "What is your total yearly income?", "Student Income", JOptionPane.QUESTION_MESSAGE);
            while (!(Double.parseDouble(validStudentIncome) > 0)) {
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Student Income", JOptionPane.ERROR_MESSAGE);
                validStudentIncome = JOptionPane.showInputDialog(null, "What is your total yearly income?", "Student Income", JOptionPane.QUESTION_MESSAGE);

            }

            String validParentIncome = JOptionPane.showInputDialog(null, "What is parent's total yearly income?", "Parent Income", JOptionPane.QUESTION_MESSAGE);
            while (!(Double.parseDouble(validStudentIncome) > 0)) {
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Parent Income", JOptionPane.ERROR_MESSAGE);
                validStudentIncome = JOptionPane.showInputDialog(null, "What is parent's total yearly income?", "Parent Income", JOptionPane.QUESTION_MESSAGE);

            }

            int isIndependent = JOptionPane.showOptionDialog(null, "Are you a dependent?", "Dependency", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            isDependent = (isIndependent == JOptionPane.YES_OPTION);

            String[] classes = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
            String standing = (String) JOptionPane.showInputDialog(null, "What is your current class standing?", "Class Standing", JOptionPane.PLAIN_MESSAGE, null, classes, null);
            if (standing.equals("Freshman") || standing.equals("Sophomore") || standing.equals("Junior") || standing.equals("Senior")) {
                standing = "Undergraduate";
            } else {
                standing = "Graduate";
            }

            FAFSA application = new FAFSA(isAcceptedStudent, isSSregistered, hasSSN, hasValidResidency, isDependent, Integer.parseInt(validAge), Integer.parseInt(validCreditHours), Double.parseDouble(validStudentIncome), Double.parseDouble(validParentIncome), standing);

            if (application.isFederalAidEligible()) {
                JOptionPane.showMessageDialog(null, "You are eligible for financial aid.", "Eligibility", JOptionPane.INFORMATION_MESSAGE);

                double loan = application.calcStaffordLoan();
                double grant = application.calcFederalGrant();
                double workStudy = application.calcWorkStudy();
                double totalAwards = application.calcFederalAidAmount();

                String displayAwardResults = "Loan amount: " + loan + "\n" +
                        "Grant amount: " + grant + "\n" +
                        "Work Study Amount: " + workStudy + "\n" +
                        "Total Award Amount: " + totalAwards;

                JOptionPane.showMessageDialog(null, displayAwardResults, "FAFSA Results", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "You are not eligible for financial aid.", "Eligibility", JOptionPane.INFORMATION_MESSAGE);
            }

            beginApp = false;

            boolean reapply;
            int resume = JOptionPane.showOptionDialog(null, "Would you like to complete another Application?", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            reapply = (resume == JOptionPane.YES_OPTION);
            if (reapply) {
                beginApp = true;
            }
        }
    }
}
