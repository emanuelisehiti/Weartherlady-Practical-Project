package ui;

    import model.Weather;
    import services.WeatherService;
    import validation.UserValidation;

    import java.awt.*;
    import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
    import java.net.URI;

    import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

    class LabelsExample extends JFrame implements ActionListener {
        JTextField tf;
        JLabel l;
        JButton b;
        JLabel l1;


        LabelsExample() {

            tf = new JTextField();
            tf.setBounds(50, 50, 150, 20);
            l1 = new JLabel();
            l1.setBounds(20, 50, 150, 20);
            l1.setText("City");
            l = new JLabel();
            l.setBounds(50, 100, 250, 20);
            b = new JButton("Check");
            b.setBounds(50, 150, 95, 30);
            b.addActionListener(this);
            add(b);
            add(tf);
            add(l);

            setSize(400, 400);
            setTitle("Weather Application    Past'el");
            setLayout(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            UserValidation userValidation = new UserValidation();
            if(tf.getText().equals("")){
                l.setText("Enter the city");
            }else if(userValidation.isValidate(tf.getText())){
                Desktop desktop = java.awt.Desktop.getDesktop();

                try {
                WeatherService weatherService = new WeatherService();

                String city = tf.getText();

                Weather weather = weatherService.getWeather(city);
                if(weather.getId() == null) {
                    // save weather to database
                    weatherService.addWeather(weather);
                }

                Double temp = weather.getTemperature() ;
                l.setText("Temperature in " + city + " is "+(temp - 273.15)+ "°C");


            } catch (Exception ex) {
                System.out.println(ex);
                l.setText("City not found");
            }
            } else {
                l.setText("Invalid input");
            }
        }


        public static void main(String[] args) {
            new LabelsExample();

        }


    }

