package seoulawake.server.global.config

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.jasypt.iv.NoIvGenerator
import org.jasypt.salt.RandomSaltGenerator
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableEncryptableProperties
class JasyptConfig(
  @Value("\${jasypt.encryptor.password}")
  val password: String
) {
  @Bean("jasyptStringEncryptor")
  fun stringEncryptor(): StringEncryptor {
    val encryptor = StandardPBEStringEncryptor()
    encryptor.setPassword(password)
    encryptor.setIvGenerator(NoIvGenerator())
    encryptor.setSaltGenerator(RandomSaltGenerator())
    return encryptor
  }
}
