## Command Package:
---


* **Load** - class that implements the load functionality.
> Command Usage : load ***src_file_path*** ***image_name***
---
* **Save** - class that implements the save functionlity.
> Command Usage : save ***dest_file_path*** ***image_name***
---

* **GreyScale** - class that implments the greyscale functionality.
> Command Usage : greyscale ***value_component*** ***src_image_name*** ***dest_img_name***

> Command Usage : greyscale ***src_image_name*** ***dest_image_name***
---

* **Brighten** - class that implements the brighten functionality.
> Command Usage : brighten ***increment_factor*** ***src_image_name*** ***dest_image_name***
---

* **Vertical Flip** - class that implmenents the vertical flip functionality.
> Command Usage : vertical-flip ***src_image_name*** ***dest_img_name***
---

* **Horizontal flip** -  class that implements the horizontal flip functionality.
> Command Usage : horizontal-flip ***src_image_name*** ***dest_img_name***
---

* **RGB Combine** - class that implements the RGB combine functionality.
> Command Usage : rgb-combine ***red_image_name*** ***green_image_name*** ***blue_image_name*** ***dest_img_name***
---

* **RGB Split** - class that implements the RGB split functionality.
> Command Usage : rgb-split ***src_img_name*** ***dest_red_image_name*** ***dest_green_image_name*** ***dest_blue_image_name*** 
---

* **blur** - class that implements the blur functionality.
> Command Usage : blur ***src_image_name*** ***dest_img_name***
---

* **sharpen** - class that implements the sharpen functionality.
> Command Usage : sharpen ***src_image_name*** ***dest_img_name***
---

* **dither** - class that implements the dither functionality.
> Command Usage : dither ***src_image_name*** ***dest_img_name***
---

* **sepia** - class that implements the sepia functionality.
> Command Usage : sepia ***src_image_name*** ***dest_img_name***
---
## UI implementation:
---
* **Load Button** -  when clicked on this button in the UI implementation will ask the user to select thed image to be displayed on the screen.
* **Save Button** - saves the image shown on the screen to the place where the user enters the path.
* **Brighten Button** - brightens the image on the scale mentioned by the user.
* **Gray Button** - on clicking the gray button user is allowed to select the operation to be performed on the gray image like transformation, red, green, blue, value, luma and intensity.
* **Vertical Flip Button** -  on clicking on this button the image displayed on the screen is vertically flipped.
* **Horizontal Flip Button** -  on clicking on this button the image displayed on the screen is horizontally flipped.
* **RGB SPLIT Button** -Splits the current image into 3 gray scale images based on the red, green and blue channels.
* **RGB Combine Button** -  Combines the last three images or the images selected by the user and shows the image on the screen.
 * **Blur Button** - Blurs the image shown on the screen and shows the blur image.
 * **Sharpen Button** - Sharpens the image shown on the screen and shows the sharpen image.
  * **Sepia Button** - Sepia transformation is applied on the image shown on the screen and the new image is displayed on the screen.
 * **Dither Button** - Dithering is applied on the image shown on the screen and the new image is displayed on the screen.
  