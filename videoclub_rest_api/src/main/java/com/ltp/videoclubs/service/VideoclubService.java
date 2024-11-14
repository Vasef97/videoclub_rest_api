package com.ltp.videoclubs.service;

import com.ltp.videoclubs.entity.Videoclub;

public interface VideoclubService {

    Videoclub getVideoclub(Long id);

    Videoclub saveVideoclub(Videoclub videoclub);

    void updateVideoclub(Long id, Videoclub videoclub);

    void deleteVideoclub(Long id);

    Iterable<Videoclub> getVideoclubs();

}
