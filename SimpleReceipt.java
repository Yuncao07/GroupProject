public class SimpleReceipt extends Receipt {
  SimpleReceipt(Account account) {
    super(account);
  }

  String getReportType() {
    return "SIMPLE RECEIPT";
  }
}
