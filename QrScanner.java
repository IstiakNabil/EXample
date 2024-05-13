import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QrScanner {

    public static String getPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select QR Code Image");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            System.out.println("No file selected.");
            return null;
        }
    }


    public static String readAndDecodeQRCode(String imagePath) {
        String qrCodeContent = ""; // Initialize the content as an empty string
        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);

            System.out.println("QR Code content: " + result.getText());
            qrCodeContent = result.getText(); // Assign the text content to the string variable
        } catch (IOException e) {
            System.err.println("Error reading the image");
            e.printStackTrace();
        } catch (NotFoundException e) {
            System.err.println("No QR code found in the image");
            e.printStackTrace();
        }
        return qrCodeContent;
    }
}    