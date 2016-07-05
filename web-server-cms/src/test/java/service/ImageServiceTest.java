package service;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.repository.ImageRepository;
import com.pigatron.web.cms.image.service.ImageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {

    @Mock
    private ImageRepository imageRepository;

    private ImageService imageService;

    @Before
    public void setup() {
        imageService = new ImageService(imageRepository);
    }

    @Test
    public void save_shouldSaveNewImage_whenNoMatchFound() {
        mockExistingImages();
        byte[] fileData = {21,22,23,24,25,26,27,28,29,30};
        Image image = new Image(fileData, "image/jpg");
        given(imageRepository.save(image)).willReturn(image);

        Image returnedImage = imageService.save(image);

        assertThat(returnedImage).isEqualTo(image);
        verify(imageRepository).save(image);
    }

    @Test
    public void save_shouldReturnExistingImage_whenMatchFound() {
        mockExistingImages();
        byte[] fileData = {11,12,13,14,15,16,17,18,19,20};
        Image image = new Image(fileData, "image/jpg");
        given(imageRepository.save(image)).willReturn(image);

        Image returnedImage = imageService.save(image);

        assertThat(returnedImage).isEqualTo(image);
        assertThat(returnedImage.getId()).isEqualTo("2");
        verify(imageRepository, never()).save(image);
    }

    private void mockExistingImages() {
        byte[] file1Data = {1,2,3,4,5,6,7,8,9,10};
        Image image1 = new Image(file1Data, "image/jpg");
        image1.setId("1");

        byte[] file2Data = {11,12,13,14,15,16,17,18,19,20};
        Image image2 = new Image(file2Data, "image/jpg");
        image2.setId("2");

        List<Image> existingImages = Arrays.asList(image1, image2);
        given(imageRepository.findAll()).willReturn(existingImages);
    }

}
