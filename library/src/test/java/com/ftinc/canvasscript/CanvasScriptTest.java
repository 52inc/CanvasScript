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

package com.ftinc.canvasscript;


import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.ftinc.canvasscript.util.Log;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CanvasScriptTest {

    private static final int SAVE_COUNT = 5;


    @Before
    public void setUp() {
        // Trip up the default logging flag
        CanvasScript.wrap(mock(Canvas.class));
        Log.setEnabled(false);
    }


    @Test
    public void shouldThrowExceptionForInvalidBitmap() throws Exception {
        Bitmap mockBitmap = mock(Bitmap.class);
        when(mockBitmap.isRecycled()).thenReturn(true);
        when(mockBitmap.isMutable()).thenReturn(false);

        try {
            CanvasScript.create(mockBitmap);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }


    @Test
    public void shouldThrowExceptionWhenPaintNotSetup() throws Exception {
        Canvas canvas = mock(Canvas.class);
        CanvasScript script = CanvasScript.wrap(canvas);

        try {
            script.circle(0, 0, 0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }


    @Test
    public void shouldReturnNullWhenWrappingCanvas() throws Exception {
        Canvas mockCanvas = mock(Canvas.class);
        CanvasScript script = CanvasScript.wrap(mockCanvas);

        Bitmap bitmap = script.draw();

        assertThat(bitmap, Matchers.nullValue());
    }


    @Test
    public void shouldPersistSaveCountInternally() throws Exception {
        Canvas canvas = mock(Canvas.class);
        when(canvas.save()).thenReturn(SAVE_COUNT);

        CanvasScript.wrap(canvas)
                .save()
                .restore()
                .draw();

        verify(canvas).save();
        verify(canvas).restoreToCount(SAVE_COUNT);
    }
}