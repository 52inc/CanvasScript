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


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class BitmapParamsTest {

    private static final float LEFT = 10f;
    private static final float TOP = 15f;

    @Mock Paint paint;
    @Mock Canvas canvas;
    @Mock Bitmap bitmap;


    @Test
    public void shouldDrawWithLeftTop() {
        BitmapParams params = new BitmapParams(bitmap, LEFT, TOP, paint);

        int result = params.draw(canvas);

        verify(canvas).drawBitmap(bitmap, LEFT, TOP, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawWithRectDestination() {
        Rect rect = mock(Rect.class);
        BitmapParams params = new BitmapParams(bitmap, null, rect, paint);

        int result = params.draw(canvas);

        verify(canvas).drawBitmap(bitmap, null, rect, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawWithRectFDestination() {
        RectF rect = mock(RectF.class);
        BitmapParams params = new BitmapParams(bitmap, null, rect, paint);

        int result = params.draw(canvas);

        verify(canvas).drawBitmap(bitmap, null, rect, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawWithMatrix() {
        Matrix matrix = mock(Matrix.class);
        BitmapParams params = new BitmapParams(bitmap, matrix, paint);

        int result = params.draw(canvas);

        verify(canvas).drawBitmap(bitmap, matrix, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}