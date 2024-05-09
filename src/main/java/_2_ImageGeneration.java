
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.openai.OpenAiImageModelName;
import dev.langchain4j.model.output.Response;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;

public class _2_ImageGeneration {

    static class createPng {

        // -----------------------
        // a. generate a png image
        // -----------------------
        // Assignment:
        //      - connect to OpenAi's Dall-E ImageModel
        //      - generate and inspect your image
        public static void main(String[] args) {

            ImageModel model = OpenAiImageModel.builder()
            .apiKey(ApiKeys.OPENAI_API_KEY)
            .modelName(OpenAiImageModelName.DALL_E_2)
            .build();

            Response<Image> response = model.generate("two very cute cats, from heaven, not from hell");
            System.out.println(response.content().url());
        }
    }

    static class savePngLocally {

        public static void main(String[] args) throws URISyntaxException {

            // -----------------------
            // a. handle and store a png image
            // -----------------------
            // Assignment:
            //      - connect to OpenAi's Dall-E ImageModel and set some more parameters
            //      - generate your image and persist it to src/main/rsources/result-images
            //      (use builder with .persistTo( ... ) )

            ImageModel model = OpenAiImageModel.builder()
            .modelName(OpenAiImageModelName.DALL_E_2)
            .persistTo(Paths.get("src/main/resources/result-images"))
            .build();

            Response<Image> response = model.generate("2 funny cats");

            System.out.println(response.content().url());
        }
    }
}
