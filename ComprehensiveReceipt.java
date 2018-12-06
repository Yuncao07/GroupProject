public class ComprehensiveReceipt extends Receipt {
  ComprehensiveReceipt(Account account) {
    super(account);
  }
  String getReportType() {
    return "COMPREHENSIVE RECEIPT";
  }
}
