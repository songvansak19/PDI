package Challenge;

public class Exercise7 {
    public static abstract class Document {
        public final void generate() {
            writeHeader();
            writeBody();
            writeFooter();
        }

        protected abstract void writeHeader();

        protected abstract void writeBody();

        protected abstract void writeFooter();
    }

    public static class InvoiceDocument extends Document {
        @Override
        protected void writeHeader() {
            System.out.println("Invoice Header");
        }

        @Override
        protected void writeBody() {
            System.out.println("Invoice Body: items and prices");
        }

        @Override
        protected void writeFooter() {
            System.out.println("Invoice Footer: total amount due");
        }
    }

    public static class ResumeDocument extends Document {
        @Override
        protected void writeHeader() {
            System.out.println("Resume Header: name and contact information");
        }

        @Override
        protected void writeBody() {
            System.out.println("Resume Body: skills and experience");
        }

        @Override
        protected void writeFooter() {
            System.out.println("Resume Footer: references");
        }
    }

    public static class ReportDocument extends Document {
        @Override
        protected void writeHeader() {
            System.out.println("Report Header: title and date");
        }

        @Override
        protected void writeBody() {
            System.out.println("Report Body: findings and analysis");
        }

        @Override
        protected void writeFooter() {
            System.out.println("Report Footer: conclusion");
        }
    }

    public static void main(String[] args) {
        Document[] documents = {
            new InvoiceDocument(),
            new ResumeDocument(),
            new ReportDocument()
        };

        for (Document document : documents) {
            document.generate();
            System.out.println();
        }
    }
}
