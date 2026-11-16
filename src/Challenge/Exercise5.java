package Challenge;

public class Exercise5 {
    public static class PatientRecord {
        private String _ssn = "Private information";
        protected String _medical_history = "Medical Record...";

        public String getSSN() {
            return _ssn;
        }
    }

    public static class OutPatientRecord extends PatientRecord {
        public String getMedicalHistory() {
            return _medical_history;
        }
    }

    public static class InPatientRecord extends PatientRecord {
        public String getMedicalHistory() {
            return _medical_history;
        }
    }

    public static void main(String[] args) {
        PatientRecord patientRecord = new PatientRecord();
        System.out.println(patientRecord.getSSN());

        OutPatientRecord outPatientRecord = new OutPatientRecord();
        outPatientRecord.getSSN();
        System.out.println(outPatientRecord.getMedicalHistory());

        InPatientRecord inPatientRecord = new InPatientRecord();
        inPatientRecord.getSSN();
        System.out.println(inPatientRecord.getMedicalHistory());
    }
}
