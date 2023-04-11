# IME: Image Manipulation and Enhancement

## MODEL

---

> The model has the following packages in it.
> * file
>
> It also hosts a ***IImage*** Interface, ***ImageObj*** Class and ***ImageSet*** Class.

### File Package:
* **IFile** - IFile represents the methods implemented by the classes which implement IFile interface.
* **PPMFile** - PPMFile represents the image file format which is in PPM. It implements the IFIle interface to implement the file methods.
* **JPEGFile** - JPEGFile represents the image file format which is in JPEG. It implements the IFile interface to implement the file methods.
* **BMPFile** - BMPFile represents the image file format which is in BMP. It implements the IFile interface to implement the file methods.
* **PNGFile** - PNGFile represents the image file format which is in PNG. It implements the IFile interface to implement the file methods.


>### *IImage* :
> IImage represents the model interface and the methods that are required for the model.

### Methods:
* ***load*** - This method when called loads the image from disk.
* **save** - This method when called saves the image to the disk.
* **greyScaleRed** - This method when called converts the RGB image to greyscale based on Red pixels.
* **greyScaleGreen** - This method when called converts the RGB image to greyscale based on green pixels.
* **greyScaleBlue** - This method when called converts the RGB image to greyscale based on the blue pixels.
* **greyScaleValue** - This method when called converts the RGB image to greyscale based on the Pixel values
* **greyScaleIntensity** - This method when called converts the RGB image to greyscale based on the intensity of the pixels.
* **greyScaleLuma** - This method when called converts the RGB image to greyscale based on the Luma of the pixels.
* **horizontalFlip** - This method when called flips the image horizontally.
* **verticalFlip** - This method when called flips the image vertically.
* **brighten** - This method when called brightens the image by the input value.
* **rgbSplit** - This method when called splits the RGB image into different color channels
* **rgbCombine** - This method when called combines the various channels of the image into RGB image.
* **tranformGreyscale** - This method when called converts the image to greyscale.
* **transformSepia** - This method when called converts the image to sepia.
* **filterBlur** - This method when called blurs the image.
* **filterSharpen** - This method when called sharpens the image.
* **dither** - This method when called dithers the image.
> ### *ImageSet* :
> This class implements the ***IImage*** Interface and holds the map between image values and corresponding name.

> ### *ImageObj* :
> This class implements all the functions mentioned in the ***IImage***. This is used to perform the said operations on a singular image.

> ### *ImageObjAdvanced* :
> This class implements all the functions mentioned in the ***IImageAdvanced***. This is used to perform the said operations on a singular image.

## VIEW

---

The view hosts a ***IView*** Interface and ***View*** Class.

> ### *IView Interface* : 
> This interface implements various methods pertaining to the System out statements of the program.

### Methods:
* **echoGetCommand** - This method when called prints a statement instructing the user to input a command.
* **toggleVerbose** - This method when called switches the verbosity of the View.
* **echoCloseCmd** - This method when called prints a statement indicating the user that the close command has been entered.
* **echoIoError** - This method when called prints a statement indicating the user that an IO error has occured.
* **echoWrongCmdError** - This method when called prints a statement indicating the user that a wrong command has been entered.
* **echoFileHandlingError** - This method when called prints a statement indicating the user a file handling exception error has occured.
* **echoImageNotFoundError** - This method when called prints a statement indicating the user that an Image under the given name has not been found.
* **echoImageNameAlreadyExistsError** - This method when called prints a statement indicating the user that image under the same exists in the memory.
* **echoLoadSuccess** - This method when called prints a statement indicating the user that the image has been loaded successfully.
* **echoSaveSuccess** - This method when called prints a statement indicating the user that the image has been saved successfully.
* **echoGreyscaleSuccess** - This method when called prints a statement indicating the user that the greyscale conversion has been completed successfully.
* **echoBrightenSuccess** - This method when called prints a statement indicating the user that the image has been brightened successfully.
* **echoFlipSuccess** - This method when called prints a stetement indicating the user that the image has been flipped successfully.
* **echoCombineSuccess** - This method when called prints a statement indicating the user that the image has been combined successfully.
* **echoSplitSuccess** - This method when called prints a statement indicating the user that the image has been splitted successfully.
* **echoScriptSuccess** - This method when called prints a statement indicating the user that the script has been executed successfully.
* **echoInvalidInputMsg** - This method when called prints a statement indicating the user that an invalid input has been entered.
* **echoFilterBlurSuccess**  This methowd when called prints a statement indicating the user that the image has been blurred successfully.
* **echoFilterSharpenSuccess** - This method when called prints a statement indicating the user that the image has been shaperend successfully.
* **echoSepiaSuccess** - This method when called prints a statement indicating the user that the image has been converted to sepia successfully.
* **echoDither** - This method when called prints a statement indicating the user that the image has been converted to dither successfully.

> ### *View* :
> This class implements the ***IView*** interface and all the methods it holds.

## CONTROLLER
---
> The controller has the following packages in it.
> * commands 
>
> Along with it also hosts a ***Helper*** class, a ***ImgControllerImpl*** class and ***ImgController*** interface.

### Command Package:

* ***IImageCommand*** -  is the interface which has  void execute() method.
* **ACommand** - class is an abstract class which implements IImageCommand interface and extends the helper.
* **Brighten** - class that implements the brighten functionality.
* **GreyScale** - class that implments the greyscale functionality.
* **Horizontal flip** -  class that implements the horizontal flip functionality.
* **Load** - class that implements the load functionality.
* **RGB Combine** - class that implements the RGB combine functionality.
* **RGB Split** - class that implements the RGB split functionality.
* **Save** - class that implements the save functionlity.
* **Vertical Flip** - class that implmenents the vertical flip functionality.
* **blur** - class that implements the blur functionality.
* **sharpen** - class that implements the sharpen functionality.
* **dither** - class that implements the dither functionality.
* **sepia** - class that implements the sepia functionality.

>### *ImgController* : 
> This Interface consist of the following methods in it.

### Methods:
* ***Run*** - This method when called from the main class takes input from the user.

>### *ImgControllerImpl* :
> ImgControllerImpl is the controller class which is called from the main. It takes input from the user and calls necessary classes from the model. Parses the output to the view.

>### *ImgControllerImplAdvanced* :
> ImgControllerImplAdvanced is the controlled class which is called from main and consist of additional functionalities. It takes input from the user and calls necessary classes from the mode. Parses the output to ViewAdvanced.

#### CITATION - IMAGES ARE TAKEN FROM MARIA ANSON.