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
import android.graphics.Color;
import android.graphics.PorterDuff;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Color.class)
public class ColorParamsTest {

    private static final int BLUE = 0xFF0000FF;
    private static final int DEFAULT_ALPHA = 255;

    @Mock Canvas canvas;


    @Before
    public void setUp() {
        initMocks(this);
    }


    @Test
    public void shouldDrawColorWithoutMode() {
        ColorParams params = new ColorParams(BLUE);

        int result = params.draw(canvas);

        verify(canvas).drawColor(BLUE);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawColorWithMode() {
        PorterDuff.Mode mode = mock(PorterDuff.Mode.class);
        ColorParams params = new ColorParams(BLUE, mode);

        int result = params.draw(canvas);

        verify(canvas).drawColor(BLUE, mode);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawRGB() {
        prepareColorMock(DEFAULT_ALPHA, 0, 0, 255);
        ColorParams params = new ColorParams(0, 0, 255);

        int result = params.draw(canvas);

        verify(canvas).drawColor(BLUE);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawARGBWithoutMode() {
        prepareColorMock(DEFAULT_ALPHA, 0, 0, 255);
        ColorParams params = new ColorParams(DEFAULT_ALPHA, 0, 0, 255);

        int result = params.draw(canvas);

        verify(canvas).drawColor(BLUE);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawARGBWithMode() {
        PorterDuff.Mode mode = mock(PorterDuff.Mode.class);
        prepareColorMock(DEFAULT_ALPHA, 0, 0, 255);
        ColorParams params = new ColorParams(DEFAULT_ALPHA, 0, 0, 255, mode);

        int result = params.draw(canvas);

        verify(canvas).drawColor(BLUE, mode);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    private void prepareColorMock(int a, int r, int g, int b) {
        mockStatic(Color.class);
        when(Color.argb(a, r, g, b)).thenReturn(BLUE);
    }
}