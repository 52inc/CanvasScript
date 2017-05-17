/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PictureParamsTest {

    @Mock Canvas canvas;
    @Mock Picture picture;


    @Test
    public void shouldDrawJustPicture() {
        PictureParams params = new PictureParams(picture);

        int result = params.draw(canvas);

        verify(canvas).drawPicture(picture);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawPictureWithRect() {
        Rect rect = mock(Rect.class);
        PictureParams params = new PictureParams(picture, rect);

        int result = params.draw(canvas);

        verify(canvas).drawPicture(picture, rect);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawPictureWithRectF() {
        RectF rect = mock(RectF.class);
        PictureParams params = new PictureParams(picture, rect);

        int result = params.draw(canvas);

        verify(canvas).drawPicture(picture, rect);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}