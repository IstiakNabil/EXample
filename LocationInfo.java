public class LocationInfo extends QrScanner {


    public static String getLocation() {
        String imagePath = getPath();
        String qrCodeContent = null;
        if (imagePath != null) {
            qrCodeContent = readAndDecodeQRCode(imagePath);
        }
        return qrCodeContent;
    }
}
