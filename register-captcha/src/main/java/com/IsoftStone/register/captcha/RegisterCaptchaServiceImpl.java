package com.IsoftStone.register.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.InitializingBean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Bachelor Wang on 2014/5/23.
 */
public class RegisterCaptchaServiceImpl implements RegisterCaptchaService,InitializingBean{

    private DefaultKaptcha producer;

    private List<String> preDefinedTexts;

    private Map<String,String> captchMap = new HashMap<String,String>();

    private int textCount = 0;
    /**
     * 继承来自 SpringFramework 的 InitializingBean
     * 该方法会被SpringFramework 初始化对象的时候调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        producer = new DefaultKaptcha();
        producer.setConfig(new Config(new Properties()));
    }

    @Override
    public String generateCaptchaKey() throws RegisterCaptchaException {

        String key = RandomGenerator.getRandomString();
        String value = getCaptchaText();

        captchMap.put(key,value);
        return key;
    }

    private String getCaptchaText() {

        if(preDefinedTexts != null && !preDefinedTexts.isEmpty()){
            String text = preDefinedTexts.get(textCount);

            textCount = (textCount + 1) % preDefinedTexts.size();
            return text;
        }else{
            return producer.createText();
        }
    }


    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws RegisterCaptchaException {
        String text = captchMap.get(captchaKey);

        if(text == null){
            throw new RegisterCaptchaException( "Captch key '" + captchaKey + "' not found!" );
        }

        BufferedImage image = producer.createImage(text);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{
            ImageIO.write(image,"jpg",out);
        }catch (IOException e){
            throw new RegisterCaptchaException( "Failed to write captcha stream!", e );
        }
        return out.toByteArray();
    }

    @Override
    public boolean validateCaptcha(String captchaKey, String captchaValue) throws RegisterCaptchaException {

        String text = captchMap.get(captchaKey);
        if(text == null){
            throw new RegisterCaptchaException( "Captch key '" + captchaKey + "' not found!" );
        }
        if(text.equals(captchaValue)){
            captchMap.remove(captchaKey);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<String> getPreDefinedTexts() {

        return preDefinedTexts;
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {
        this.preDefinedTexts = preDefinedTexts;
    }
}
