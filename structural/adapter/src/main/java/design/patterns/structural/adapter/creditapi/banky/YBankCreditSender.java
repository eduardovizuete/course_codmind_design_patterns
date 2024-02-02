package design.patterns.structural.adapter.creditapi.banky;

public class YBankCreditSender {
    
    public void sendCreditForValidate(final YBankCreditApprove request, final YBankCreditSenderListener listener) {
        new Thread(() -> {
            System.out.println("yBank recibió su la solicitud en un momento tendrá la respuesta, sea paciente porfavor");
            YBankCreditApproveResult response = new YBankCreditApproveResult();
            
            if (request.getCredit() <= 1500) {
                response.setApproved("Y");
            } else {
                response.setApproved("N");
            }
            
            try {
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            listener.notifyCreditResult(response);
        }).start();
    }
    
}
