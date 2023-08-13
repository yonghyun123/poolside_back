package poolside.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import poolside.common.dto.Response;
import poolside.controller.dto.request.PriceSaveRequestDto;
import poolside.controller.dto.response.PriceResponseDto;
import poolside.service.PriceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/prices")
    public Response<Long> addPrice(@RequestBody PriceSaveRequestDto savePrice) {
        return Response.ok(priceService.save(savePrice));
    }

    @PutMapping("/prices/{id}")
    public Response<Long> updatePrice(@PathVariable Long id, PriceSaveRequestDto updatePrice){
        return Response.ok(priceService.update(id, updatePrice));
    }

    @DeleteMapping("/prices/{id}")
    public Response<Long> deletePrice(@PathVariable Long id) {
        return Response.ok(priceService.delete(id));
    }

    @GetMapping("/prices/{id}")
    public Response<PriceResponseDto> findPriceById(@PathVariable Long id) {
        return Response.ok(priceService.findPriceById(id));
    }

    @GetMapping("/prices")
    public Response<List<PriceResponseDto>> findPrices() {
        return Response.ok(priceService.findPrices());
    }
}
